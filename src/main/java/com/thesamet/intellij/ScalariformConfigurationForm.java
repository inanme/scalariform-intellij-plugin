package com.thesamet.intellij;

import javax.swing.*;

/**
 * Created by nadavsr on 5/31/14.
 */
public class ScalariformConfigurationForm {
    JCheckBox alignParameters;
    JCheckBox alignSingleLineCase;
    JCheckBox compactControlReadability;
    JCheckBox compactStringConcatenation;
    JCheckBox doubleIndentConstructorArguments;
    JCheckBox formatXML;
    JCheckBox indentPackageBlocks;
    JCheckBox indentWithTabs;
    JCheckBox multilineScalaDocCommentsStartOnFirstLine;
    JCheckBox danglingCloseParenthesis;
    JCheckBox placeScaladocAsterisksBeneathSecondAsterisk;
    JCheckBox preserveSpaceBeforeArguments;
    JCheckBox rewriteArrowSymbols;
    JCheckBox spaceBeforeColon;
    JCheckBox spaceInsideParenthesis;
    JCheckBox spacesWithinPatternBinders;
    JCheckBox indentLocalDefs;
    JCheckBox spaceInsideBrackets;
    JTextField maxArrowIndent;
    JTextField indentSpaces;

    JPanel rootComponent;

    public JPanel getRootComponent() {
        return rootComponent;
    }

    public void setData(ScalariformState data) {
        alignParameters.setSelected(data.alignParameters);
        alignSingleLineCase.setSelected(data.alignSingleLineCase);
        compactControlReadability.setSelected(data.compactControlReadability);
        compactStringConcatenation.setSelected(data.compactStringConcatenation);
        doubleIndentConstructorArguments.setSelected(data.doubleIndentConstructorArguments);
        formatXML.setSelected(data.formatXML);
        indentPackageBlocks.setSelected(data.indentPackageBlocks);
        indentWithTabs.setSelected(data.indentWithTabs);
        multilineScalaDocCommentsStartOnFirstLine.setSelected(data.multilineScalaDocCommentsStartOnFirstLine);
        danglingCloseParenthesis.setSelected(data.danglingCloseParenthesis);
        placeScaladocAsterisksBeneathSecondAsterisk.setSelected(data.placeScaladocAsterisksBeneathSecondAsterisk);
        preserveSpaceBeforeArguments.setSelected(data.preserveSpaceBeforeArguments);
        rewriteArrowSymbols.setSelected(data.rewriteArrowSymbols);
        spaceBeforeColon.setSelected(data.spaceBeforeColon);
        spaceInsideParenthesis.setSelected(data.spaceInsideParenthesis);
        spacesWithinPatternBinders.setSelected(data.spacesWithinPatternBinders);
        indentLocalDefs.setSelected(data.indentLocalDefs);
        spaceInsideBrackets.setSelected(data.spaceInsideBrackets);
        indentSpaces.setText(data.indentSpaces.toString());
        maxArrowIndent.setText(data.maxArrowIndent.toString());
    }

    public void getData(ScalariformState data) {
        data.alignParameters = alignParameters.isSelected();
        data.alignSingleLineCase = alignSingleLineCase.isSelected();
        data.compactControlReadability = compactControlReadability.isSelected();
        data.compactStringConcatenation = compactStringConcatenation.isSelected();
        data.doubleIndentConstructorArguments = doubleIndentConstructorArguments.isSelected();
        data.formatXML = formatXML.isSelected();
        data.indentPackageBlocks = indentPackageBlocks.isSelected();
        data.indentWithTabs = indentWithTabs.isSelected();
        data.multilineScalaDocCommentsStartOnFirstLine = multilineScalaDocCommentsStartOnFirstLine.isSelected();
        data.danglingCloseParenthesis = danglingCloseParenthesis.isSelected();
        data.placeScaladocAsterisksBeneathSecondAsterisk = placeScaladocAsterisksBeneathSecondAsterisk.isSelected();
        data.preserveSpaceBeforeArguments = preserveSpaceBeforeArguments.isSelected();
        data.rewriteArrowSymbols = rewriteArrowSymbols.isSelected();
        data.spaceBeforeColon = spaceBeforeColon.isSelected();
        data.spaceInsideParenthesis = spaceInsideParenthesis.isSelected();
        data.spacesWithinPatternBinders = spacesWithinPatternBinders.isSelected();
        data.indentLocalDefs = indentLocalDefs.isSelected();
        data.spaceInsideBrackets = spaceInsideBrackets.isSelected();
        try {
            data.indentSpaces = Integer.parseInt(indentSpaces.getText());
        } catch (NumberFormatException e) {
        }
        try {
            data.maxArrowIndent = Integer.parseInt(maxArrowIndent.getText());
        } catch (NumberFormatException e) {
        }


    }

    /**
     * @param data
     * @return
     */
    public boolean isModified(ScalariformState data) {
        //@formatter:off
        if (alignParameters.isSelected() != data.alignParameters) return true;
        if (alignSingleLineCase.isSelected() != data.alignSingleLineCase) return true;
        if (compactControlReadability.isSelected() != data.compactControlReadability) return true;
        if (compactStringConcatenation.isSelected() != data.compactStringConcatenation) return true;
        if (doubleIndentConstructorArguments.isSelected() != data.doubleIndentConstructorArguments) return true;
        if (formatXML.isSelected() != data.formatXML) return true;
        if (indentPackageBlocks.isSelected() != data.indentPackageBlocks) return true;
        if (indentWithTabs.isSelected() != data.indentWithTabs) return true;
        if (multilineScalaDocCommentsStartOnFirstLine.isSelected() != data.multilineScalaDocCommentsStartOnFirstLine) return true;
        if (danglingCloseParenthesis.isSelected() != data.danglingCloseParenthesis) return true;
        if (placeScaladocAsterisksBeneathSecondAsterisk.isSelected() != data.placeScaladocAsterisksBeneathSecondAsterisk) return true;
        if (preserveSpaceBeforeArguments.isSelected() != data.preserveSpaceBeforeArguments) return true;
        if (rewriteArrowSymbols.isSelected() != data.rewriteArrowSymbols) return true;
        if (spaceBeforeColon.isSelected() != data.spaceBeforeColon) return true;
        if (spaceInsideParenthesis.isSelected() != data.spaceInsideParenthesis) return true;
        if (spacesWithinPatternBinders.isSelected() != data.spacesWithinPatternBinders) return true;
        if (indentLocalDefs.isSelected() != data.indentLocalDefs) return true;
        if (spaceInsideBrackets.isSelected() != data.spaceInsideBrackets) return true;
        if (indentSpaces.getText() != data.indentSpaces.toString()) return true;
        if (maxArrowIndent.getText() != data.maxArrowIndent.toString()) return true;
        return false;
    }
}
