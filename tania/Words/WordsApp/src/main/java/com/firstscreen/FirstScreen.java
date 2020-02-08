package com.firstscreen;

import com.firstscreen.category2.Categories2Dao;
import com.firstscreen.category2.Category2View;
import com.firstscreen.details.DetailsView;
import com.firstscreen.details2.Details2View;
import com.firstscreen.details2.DetailsDao2;
import com.firstscreen.login.LoginView;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.RuntimeArgsService;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.license.License;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

@License(key = "e7f092a3-8f19-4545-82f8-f8afbb19c611")
public class FirstScreen extends MobileApplication {

    private LoginView loginView = new LoginView();
    //private CategoryView categoryView = new CategoryView();
    //private DetailsView detailsView = new DetailsView();
    public Details2View detailsView2 = new Details2View(this);
    public Categories2Dao categoriesDao2 = new Categories2Dao();




    private Category2View categoryView2 = new Category2View(this);
    public DetailsDao2 detailsDao2 = new DetailsDao2();

    @Override
    public void init() {






        addViewFactory(HOME_VIEW, () -> {
            return loginView;
        });
        /*addViewFactory("category_view", () -> {
            return categoryView;
        });*/
        addViewFactory("category2_view", () -> {
            return categoryView2;
        });
       /* addViewFactory("details_view", () -> {
            return detailsView;
        });*/
        addViewFactory("details2_view", () -> {
            return detailsView2;
        });
        //categoryView.mobileApplication = this;
        //detailsView.mobileApplication = this;
    }

    @Override
    public void postInit(Scene scene) {
        loginView.startBtn.setOnAction(e -> {
                    try {
                        categoryView2.refreshFirst();
                    }catch(Throwable ex){
                        ex.printStackTrace();
                    }
                    switchView("category2_view");
                }
        );
        loginView.widthProperty.bind(scene.widthProperty());
        loginView.heightProperty.bind(scene.heightProperty());

      //  detailsView.widthProperty.bind(scene.widthProperty());
      //  detailsView.heightProperty.bind(scene.heightProperty());

       // categoryView.widthProperty.bind(scene.widthProperty());
       // categoryView.heightProperty.bind(scene.heightProperty());

        categoryView2.widthProperty.bind(scene.widthProperty());
        categoryView2.heightProperty.bind(scene.heightProperty());

        detailsView2.widthProperty.bind(scene.widthProperty());
        detailsView2.heightProperty.bind(scene.heightProperty());

        Swatch.BLUE.assignTo(scene);
        ((Stage) scene.getWindow()).getIcons().add(new Image(FirstScreen.class.getResourceAsStream("/LOGO.png")));

    }

    /*public void refreshDetailView(Category category, List<Details> detailsList) {
        detailsView.refresh(category, detailsList);
    }

    public void backFromDetails() {
        categoryView.backFromDetails();
    }*/
}
