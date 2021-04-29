package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.mygdx.game.Config.BaseScreen;
import com.mygdx.game.Objects.Gatito;

public class GameScreen extends BaseScreen {

    public GameScreen(MyGdxGame game) {
        super(game);
    }
    Gatito P1 = new Gatito(300, 250, false);
    Gatito P2 = new Gatito(750, 250, true);

    @Override
    public void show() {

        stage.addActor(P1);
        stage.addActor(P2);
//        gatito.addAction(Actions.moveBy(30, 30, 1));
//        gatito.addAction(Actions.rotateBy(360 * 10, 0.2f));
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.7f, 0.54f, 0.87f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();


    }
}