package com.thesamet.intellij;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;

/**
 * Created by gil308 on 12/10/2016.
 */
@State(name = "ScalariformSettings", storages = {@Storage("scalariform.xml")})
public class ScalariformState implements PersistentStateComponent<ScalariformState> {
    public boolean alignParameters = false;
    public boolean alignSingleLineCase = false;
    public boolean compactControlReadability = false;
    public boolean compactStringConcatenation = false;
    public boolean doubleIndentConstructorArguments = false;
    public boolean formatXML = false;
    public boolean indentPackageBlocks = true;
    public boolean indentWithTabs = false;
    public boolean multilineScalaDocCommentsStartOnFirstLine = false;
    public boolean danglingCloseParenthesis = false;
    public boolean placeScaladocAsterisksBeneathSecondAsterisk = false;
    public boolean preserveSpaceBeforeArguments = false;
    public boolean rewriteArrowSymbols = false;
    public boolean spaceBeforeColon = false;
    public boolean spaceInsideParenthesis = false;
    public boolean spacesWithinPatternBinders = true;
    public boolean indentLocalDefs;
    public boolean spaceInsideBrackets;
    public Integer maxArrowIndent = 40;
    public Integer indentSpaces = 2;

    @Override
    public void loadState(ScalariformState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    @Override
    public ScalariformState getState() {
        return this;
    }
}
