package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Config.BaseScreen;

public class PantallaInicial extends BaseScreen {
    public PantallaInicial(MyGdxGame game) {
        super(game);
    }

    @Override
    public void show() {




        ImageButton.ImageButtonStyle buttonStartStyle = new ImageButton.ImageButtonStyle();
        buttonStartStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture("readyButton.png")));
        buttonStartStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture("readyButtonPressed.png")));
        ImageButton buttonStart = new ImageButton(buttonStartStyle);
        buttonStart.setPosition(30,10);
        //no cambia de tamaño, no se por qué
        buttonStart.setSize(24*10, 10*10);
        buttonStart.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                setScreen(new SelectionScreen(game));
                return true;
            }
        });
        stage.middleCenter.addActor(buttonStart);

        ImageButton.ImageButtonStyle buttonQuitStyle = new ImageButton.ImageButtonStyle();
        buttonQuitStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture("quit.png")));
        buttonQuitStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture("quitpressed.png")));
        ImageButton buttonQuit = new ImageButton(buttonQuitStyle);

        buttonQuit.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                System.exit(0);
                return true;
            }
        });

        stage.middleCenter.addActor(buttonQuit);
    }
}
