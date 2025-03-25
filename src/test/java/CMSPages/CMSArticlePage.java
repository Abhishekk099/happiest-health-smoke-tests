package CMSPages;

import net.serenitybdd.core.pages.PageObject;

import net.serenitybdd.screenplay.targets.Target;


public class CMSArticlePage extends PageObject {
    public static Target AddNewPost = Target.the("Category Field").locatedBy("//a[@class='page-title-action'][normalize-space(text() ='Add New Post')]");
    public static Target AddNewArticleHeader = Target.the("Category Field").locatedBy("//h1[@class='wp-heading-inline']");
    public static Target Addtitle = Target.the("AddTitle Field").locatedBy("//input[@name='post_title']");
    public static Target Body = Target.the("Body Field").locatedBy("//body[@id='tinymce'][@data-id='content']");
    public static String BodyFrame = "#content_ifr";
    public static Target Catagory = Target.the("{0} Catagory").
            locatedBy("//label[contains(text(),'{0}')]");
    public static Target InputboxWithLabel = Target.the("{0} label").
            locatedBy("//label[normalize-space(text())='{0}']/parent::div/following-sibling::*//input[not(@type='hidden')]");
    public static Target TextAreaBoxWithLabel = Target.the("{0} label").
            locatedBy("//label[normalize-space(text())='{0}']/parent::div/following-sibling::*//textarea");
    public static Target ExpertTextBox = Target.the("excerpt text box").
            locatedBy("#excerpt");
    public static Target PublishButton = Target.the("excerpt text box").
            locatedBy("#publish");

    public static Target InputBoxWithLabel = Target.the("{0} labelName").
            locatedBy("//label[contains(text(), '{0}')]/following::input[1]");
	public static Target CheckboxWithLabel = Target.the("{0} labelName").
            locatedBy("//label[contains(text(), '{0}')]/following::input[2]");

    public static Target SelectRelatedPosts = Target.the("{0} Select Related Posts").
            locatedBy("//label[text()='Select Related Posts']/parent::div/following-sibling::*//select");
    public static Target SelectRelatedPostsInputbox = Target.the("{0} Select Related Posts").
            locatedBy("//label[text()='Select Related Posts']/parent::div/following-sibling::*//span[@class='select2-selection select2-selection--multiple']");
    public static Target WebminarCheckbox = Target.the("{0} Webminar Checkbox").
            locatedBy("//span[text()='{0}']/preceding-sibling::input");

    public static Target AddImagelink = Target.the("{0} add image link").
            locatedBy("//label[text()='{0}']/..//following-sibling::*//a[text()='Add Image']");
    public static Target AddlinkButtonInContent =Target.the("{0} add link Button In Content").
            locatedBy("#mceu_9-button");

}