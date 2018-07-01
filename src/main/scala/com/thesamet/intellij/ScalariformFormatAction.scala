package com.thesamet.intellij

import com.intellij.openapi.actionSystem.{AnAction, AnActionEvent, CommonDataKeys}
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.fileEditor.{FileDocumentManager, FileEditorManager}
import scalariform.formatter.preferences._
import scalariform.formatter.preferences.AlignSingleLineCaseStatements.MaxArrowIndent
import scalariform.formatter.ScalaFormatter
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.editor.Document

case class FileDocument(file: VirtualFile, document: Document) {
  def isScala: Boolean = file.getFileType.getName == "Scala"
}
class ScalariformFormatAction extends AnAction {
  override def update(event: AnActionEvent): Unit = {
    event.getPresentation.setEnabled(getCurrentFileDocument(event).exists(_.isScala))
  }

  override def actionPerformed(event: AnActionEvent) {
    lazy val pref = formattingPreferences
    getCurrentFileDocument(event)
      .filter(_.isScala)
      .foreach {
        fileDoc =>
          val source = fileDoc.document.getText()
          val formatted = ScalaFormatter.format(source, formattingPreferences = pref)
          if (source != formatted) {
            ApplicationManager.getApplication.runWriteAction(new Runnable {
              override def run(): Unit = {
                fileDoc.document.setText(formatted)
              }
            })
          }
      }
  }

  private def getCurrentFileDocument(event: AnActionEvent): Option[FileDocument] = for {
    project <- Option(event.getData(CommonDataKeys.PROJECT))
    editor <- Option(FileEditorManager.getInstance(project).getSelectedTextEditor)
    document <- Option(editor.getDocument)
    vfile <- Option(FileDocumentManager.getInstance().getFile(document))
  } yield FileDocument(vfile, document)

  //https://github.com/scala-ide/scalariform/blob/master/formatterPreferences.properties
  private def formattingPreferences: FormattingPreferences = {
    val component: ScalariformState = ServiceManager.getService(classOf[ScalariformState])
    FormattingPreferences
      .setPreference(RewriteArrowSymbols, component.rewriteArrowSymbols)
      .setPreference(SpaceBeforeColon, component.spaceBeforeColon)
      .setPreference(CompactStringConcatenation, component.compactStringConcatenation)
      .setPreference(PreserveSpaceBeforeArguments, component.preserveSpaceBeforeArguments)
      .setPreference(AlignParameters, component.alignParameters)
      .setPreference(DoubleIndentConstructorArguments, component.doubleIndentConstructorArguments)
      .setPreference(FormatXml, component.formatXML)
      .setPreference(IndentPackageBlocks, component.indentPackageBlocks)
      .setPreference(AlignSingleLineCaseStatements, component.alignSingleLineCase)
      .setPreference(IndentLocalDefs, component.indentLocalDefs)
      .setPreference(DanglingCloseParenthesis, if (component.danglingCloseParenthesis) Prevent else Preserve)
      .setPreference(SpaceInsideParentheses, component.spaceInsideParenthesis)
      .setPreference(SpaceInsideBrackets, component.spaceInsideBrackets)
      .setPreference(SpacesWithinPatternBinders, component.spacesWithinPatternBinders)
      .setPreference(MultilineScaladocCommentsStartOnFirstLine, component.multilineScalaDocCommentsStartOnFirstLine)
      .setPreference(IndentWithTabs, component.indentWithTabs)
      .setPreference(CompactControlReadability, component.compactControlReadability)
      .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, component.placeScaladocAsterisksBeneathSecondAsterisk)
      .setPreference(IndentSpaces, component.indentSpaces.toInt)
      .setPreference(MaxArrowIndent, component.maxArrowIndent.toInt)
  }

}
