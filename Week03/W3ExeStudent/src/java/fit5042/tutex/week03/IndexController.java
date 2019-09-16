package fit5042.tutex.week03;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 * * * @author Messom
 */
@Named(value = "indexController")
@RequestScoped
public class IndexController {

    private String pageTitle;

    public IndexController() { // Set the page title
        pageTitle = "Viewing Movies" + " | " + MovieApplication.APP_TITLE;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
}
