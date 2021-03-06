package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Config.BaseScreen;
import com.mygdx.game.Objects.Gatito;

public class GameScreen extends BaseScreen {

    public GameScreen(MyGdxGame game) {
        super(game);
    }
    Gatito P1 = new Gatito(300, 250, false, Cosingas.renderizador.pj1);
    Gatito P2 = new Gatito(750, 250, true, Cosingas.renderizador.pj2.split("2")[0]);

    private Texture background = new Texture("pui.png");

    @Override
    public void show() {
        System.out.println(Cosingas.renderizador.pj1);
        System.out.println(Cosingas.renderizador.pj2);
        stage.addActor(P1);
        stage.addActor(P2);

        onclik(){
            Cosigncas.juego.jugar(carta);
        }

        //  no borrar :
//        gatito.addAction(Actions.moveBy(30, 30, 1));
//        gatito.addAction(Actions.rotateBy(360 * 10, 0.2f));


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        //Testingo P1:
        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
           P1.getMove().kick(P1);
            P1.gatitoMoviendose = Assets.getAnimation(P1.getMove().getName(), P1.getMove().getMs(), P1.getMove().loopMode());
        }
        //cuando el gato deje de hacer la animación vuelve a idle
        else if (P1.gatitoMoviendose.isAnimationFinished(P1.stateTime)){
            P1.getMove().idle(P1);
            P1.gatitoMoviendose = Assets.getAnimation(P1.getMove().getName(), P1.getMove().getMs(), P1.getMove().loopMode());
        }


        //Testingo P2:
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            P2.getMove().punch(P2);
            P2.gatitoMoviendose = Assets.getAnimation(P2.getMove().getName(), P2.getMove().getMs(), P2.getMove().loopMode());
        }else if (P1.gatitoMoviendose.isAnimationFinished(P1.stateTime)){
            P2.getMove().idle(P1);
            P2.gatitoMoviendose = Assets.getAnimation(P2.getMove().getName(), P2.getMove().getMs(), P2.getMove().loopMode());
        }

        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);
        stage.getBatch().end();
        stage.act(delta);
        stage.draw();


    }
}