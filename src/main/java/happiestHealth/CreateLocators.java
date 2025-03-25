package happiestHealth;

public class CreateLocators {

    public static final String SPANTAGNAME = "//span";
    public static final String LINKTAGNAME = "//a";

    public static final String OPENINGSQUAREBRACKET = "[";

    public static final String CLOSINGSQUAREBRACKET = "]";

    public static final String OPENINGROUNDBRACKET = "(";

    public static final String CLOSINGROUNDBRACKET = ")";


    public static String createLink(String linkName) {

        String xPathValue;
        xPathValue = linkName.contains("'") ? LINKTAGNAME + "[" + "normalize-space(text())=" + "\"" + linkName + "\"" + "]" : LINKTAGNAME + "[" + "normalize-space(text())=" + "'" + linkName + "'" + "]";
        return xPathValue;
    }

    public static String createPartialLink(String partialLinkName) {
        String xPathValue;
        xPathValue = partialLinkName.contains("'") ? LINKTAGNAME + "[" + "contains(normalize-space(text())," + "\"" + partialLinkName + "\"" + ")]" : LINKTAGNAME + "[" + "contains(normalize-space(text())," + "'" + partialLinkName + "'" + ")]";
        return xPathValue;

    }

    public static String createLinkUsingSource(String linkName) {

        String xPathValue;
        xPathValue = linkName.contains("'") ? LINKTAGNAME + "[contains(" + "@href," + "\"" + linkName + "\"" + ")]" : LINKTAGNAME + "[contains(" + "@href," + "'" + linkName + "'" + ")]";
        return xPathValue;
    }

    public static String createLinkForGraphics(String linkName) {

        String xPathValue;
        xPathValue = linkName.contains("'") ? "//*[contains(" + "@data-name," + "\"" + linkName + "\"" + ")]" : "//*[contains(" + "@data-name," + "'" + linkName + "'" + ")]";
        return xPathValue;
    }

    public static String createInputField(String inputField) {

        String xPathValue;

        //   xPathValue = "//textarea[@placeholder='" + inputField + "' or //input[@placeholder='" + inputField + "']]";
        xPathValue = "//input[@placeholder='" + inputField + "' or @name='"+inputField+"']";

        return xPathValue;
    }

    public static String createInputFieldUsingLabel(String labelName) {

        String xPathValue;

        xPathValue=createTextField(labelName)+"/following::input[1]";

        return xPathValue;
    }

    public static String createDropDownFieldXpath(String dropDownField) {

        String xPathValue;

        //   xPathValue = "//textarea[@placeholder='" + inputField + "' or //input[@placeholder='" + inputField + "']]";
        xPathValue = "//select[@id='" + dropDownField + "']";

        return xPathValue;
    }


    public static String createTextField(String textField) {

        String xPathValue;

        xPathValue = textField.contains("'") ? "//*[" + "normalize-space(text())=" + "\"" + textField + "\"" + "]" : "//*[" + "normalize-space(text())=" + "'" + textField + "'" + "]";

        return xPathValue;
    }

    public static String createHeaderField(String textField) {

        String xPathValue;

        xPathValue = textField.contains("'") ? "//h1[" + "normalize-space(text())=" + "\"" + textField + "\"" + "]" : "//h1[" + "normalize-space(text())=" + "'" + textField + "'" + "]";

        return xPathValue;
    }


    public static String createWebButtonField(String webButtonField) {

        String xPathValue;

        xPathValue = webButtonField.contains("'") ? "//button[contains(normalize-space(text())," + "\"" + webButtonField + "\"" + ")]" : "//*[contains(normalize-space(text())," + "'" + webButtonField + "'" + ")]";

        return xPathValue;
    }

    public static String createButtonField(String webButtonField) {

        String xPathValue;

        xPathValue = webButtonField.contains("'") ? "//button[contains(" + "normalize-space(text())," + "\"" + webButtonField + "\"" + ")]" : "//button[contains(" + "normalize-space(text())," + "'" + webButtonField + "'" + ")]";

        return xPathValue;
    }

    public static String createRadioButtonField(String radioButtonField) {

        String xPathValue;

       // xPathValue = radioButtonField.contains("'") ? "//*[contains(" + "normalize-space(@value)," + "\"" + radioButtonField + "\"" + ")]" : "//*[contains(" + "normalize-space(@value)," + "'" + radioButtonField + "'" + ")]";
        xPathValue="//input[contains(normalize-space(@value),\""+radioButtonField+"\") or contains(@name,\""+radioButtonField+"\")]";
        return xPathValue;
    }

    public static String createCheckBoxField(String checkBoxField) {

        String xPathValue;

        xPathValue="//*[contains(normalize-space(text()),"+checkBoxField+") or contains(@name,"+checkBoxField+")]/preceding::input[@type='checkbox']";
        return xPathValue;
    }

    public static String createWebEditBoxField(String webEditBoxField) {

        String xPathValue;

        xPathValue = "//input[@value=\"" + webEditBoxField + "\" or @name=\"" + webEditBoxField + "\" or @id=\"" + webEditBoxField + "\"]";
        return xPathValue;
    }

    public static String createImageField(String imageSource) {

        String xPathValue;

        xPathValue = "//img[contains(@src,\""+imageSource+"\") or @alt=\""+imageSource+"\"]";

        return xPathValue;
    }

    public static String createTextAreaField(String textAreaName) {

        String xPathValue;

        xPathValue = "//textarea[@name=\"" + textAreaName + "\"]";

        return xPathValue;
    }

    public static String createInputAreaFieldUsingName(String inputFieldName) {

        String xPathValue;

        xPathValue = "//input[@name=\"" + inputFieldName + "\"]";

        return xPathValue;
    }

    public static String createInputAreaFieldUsingPlaceholderOrType(String inputFieldName) {

        String xPathValue;

        xPathValue = "//input[contains(@placeholder,\"" + inputFieldName + "\") or contains(@type,\"" + inputFieldName + "\")or contains(@name,\"" + inputFieldName + "\") or contains(@id,\"" + inputFieldName + "\")]";

        return xPathValue;
    }

    public static String createTextAreaFieldUsingPlaceholderOrType(String textAreaFieldName) {

        String xPathValue;

        xPathValue = "//textarea[contains(@placeholder,\"" + textAreaFieldName + "\") or contains(@type,\"" + textAreaFieldName + "\") or contains(@name,\"" + textAreaFieldName + "\")]";

        return xPathValue;
    }

    public static String createInputUsingPrecedingTextOfLabelElement(String PrecedingText){
        String xPathValue;
        xPathValue = "//input[@type='checkbox' and following-sibling::text()[1][normalize-space()='" + PrecedingText + "']]";
        return xPathValue;
    }



   /* public static String createWebButtonNextToLink(String webButton,String linkText) {

        String linkXPathValue;
        String webButtonXpathValue;

        linkXPathValue = linkText.contains("'") ? "//*[contains(" + "normalize-space(text())," + "\"" + linkText + "\"" + ")]" : "//*[contains(" + "normalize-space(text())," + "'" + linkText + "'" + ")]";
        webButtonXpathValue=

        return xPathValue;
    }*/


}
