package com.gluonapplication;

import com.gluonhq.charm.glisten.application.GlassPane;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.ProgressIndicator;
import com.gluonhq.charm.glisten.layout.Layer;
import com.gluonhq.charm.glisten.layout.layer.PopupView;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class MyLayerViewCustomProgress extends View {
        private Layer layer;


    public MyLayerViewCustomProgress() {
        Button btn = new Button("click");
        setCenter(btn);

        btn.setOnAction(e->{
            if (layer == null) {
                layer = createLayer();
            }
            layer.show();
        });
    }

    private Layer createLayer() {
        return new Layer() {
            private final Node root;
            private final double size = 150;
            final GlassPane glassPane = MobileApplication.getInstance().getGlassPane();

            {
                setBackgroundFade(0.5);
                ProgressIndicator progressIndicator = new ProgressIndicator();
                progressIndicator.setRadius(50);
                root = progressIndicator;
                //root.setStyle("-fx-background-color: white;");
                getChildren().add(root);
            }

            @Override
            public void layoutChildren() {
                super.layoutChildren();
                root.setVisible(isShowing());
                if (!isShowing()) {
                    return;
                }
                root.resize(size, size);
                //resizeRelocate((glassPane.getWidth() - size)/2, (glassPane.getHeight()- size)/2, size, size);
                //resize(200,200);
                relocate(glassPane.getWidth()/2-50, glassPane.getHeight()/2-50);
            }
        };
    }


}
