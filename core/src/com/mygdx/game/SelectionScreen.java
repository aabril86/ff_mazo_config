package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Config.BaseImageButton;
import com.mygdx.game.Config.BaseScreen;
import com.mygdx.game.Config.MyStage;
import com.mygdx.game.Objects.Juego;
import com.mygdx.game.Objects.Renderizador;
import main.java.Mensaje;


public class SelectionScreen extends BaseScreen {

    private boolean selected = false;
    private Texture background;
    Image pj = new Image();
    private String pjSeleccionado = null;

    public SelectionScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void show() {
        Cosingas.juego = new Juego();
        Cosingas.renderizador = new Renderizador(game);
        background = new Texture("fondaso.png");

        BaseImageButton buttonReady = new BaseImageButton("readyButton.png", "readyButtonPressed.png", 240, 64, 525, 54);
        stage.addActor(buttonReady);

        //para testeo
        buttonReady.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if(pjSeleccionado != null){
                    Cosingas.juego.ready(pjSeleccionado);
                }
//                setScreen(new GameScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        Image header = new Image(new Texture("selectFighter.png"));
        header.setPosition(366, 610);

        stage.topCenter.addActor(header);

        //FRAMES DE LOS PERSONAJES PARA LA SELECCIÓN
        BaseImageButton gokuFrame = new BaseImageButton("gokuSelection.png", "gokuSelected.png", 107, 107, 491, 458);
        gokuFrame.onEnter(() -> showPj(stage, "gokuitot.png"));


        BaseImageButton furrieFrame = new BaseImageButton("furrieSelection.png", "furrieSelected.png", 107, 107, 491, 307);
        furrieFrame.onEnter(() -> showPj(stage, "curie.png"));

        BaseImageButton leeFrame = new BaseImageButton("leeSelection.png", "leeSelected.png", 107, 107, 491, 156);
        leeFrame.onEnter(() -> {
            showPj(stage, "miaulee.png");
        });

        BaseImageButton jacksonFrame = new BaseImageButton("miauchaelSelection.png", "miauchaelSelected.png", 107, 107, 662, 459);
        jacksonFrame.onEnter(() -> {
            showPj(stage, "heeHEE.png");
        });

        BaseImageButton pateFrame = new BaseImageButton("pateSelection.png", "pateSelected.png", 107, 107, 662, 307);
        pateFrame.onEnter(() -> {
            showPj(stage, "pate2.png");
        });

        BaseImageButton pussoliniFrame = new BaseImageButton("pussoliniSelection.png", "pussoliniSelected.png", 107, 107, 662, 156);
        pussoliniFrame.onEnter(() -> {
            showPj(stage, "PUSSOLINI.png");
        });

        gokuFrame.onClick(() -> {
            if (!selected) {
                selected = selectPj(gokuFrame, "goku");
                pjSeleccionado = "goku";
            } else {
                unselectPjs(gokuFrame, furrieFrame, leeFrame, jacksonFrame, pateFrame, pussoliniFrame);
                selected = selectPj(gokuFrame, "goku");
            }
        });
        furrieFrame.onClick(() -> {
            if (!selected) {
                pjSeleccionado = "furrie";
                selected = selectPj(furrieFrame, "furrie");
            } else {
                unselectPjs(gokuFrame, furrieFrame, leeFrame, jacksonFrame, pateFrame, pussoliniFrame);
                selected = selectPj(furrieFrame, "furrie");
            }
        });
        leeFrame.onClick(() -> {
            if (!selected) {
                pjSeleccionado = "lee";
                selected = selectPj(leeFrame, "lee");
            } else {
                unselectPjs(gokuFrame, furrieFrame, leeFrame, jacksonFrame, pateFrame, pussoliniFrame);
                selected = selectPj(leeFrame, "lee");
            }
        });
        jacksonFrame.onClick(() -> {
            if (!selected) {
                selected = selectPj(jacksonFrame, "miauchael");
                pjSeleccionado = "jackson";
            } else {
                unselectPjs(gokuFrame, furrieFrame, leeFrame, jacksonFrame, pateFrame, pussoliniFrame);
                selected = selectPj(jacksonFrame, "miauchael");
            }
        });
        pateFrame.onClick(() -> {
            if (!selected) {
                selected = selectPj(pateFrame, "pate");
                pjSeleccionado = "pate";
            } else {
                unselectPjs(gokuFrame, furrieFrame, leeFrame, jacksonFrame, pateFrame, pussoliniFrame);
                selected = selectPj(pateFrame, "pate");
            }
        });
        pussoliniFrame.onClick(() -> {
            if (!selected) {
                selected = selectPj(pussoliniFrame, "pussolini");
                pjSeleccionado = "pussolini";
            } else {
                unselectPjs(gokuFrame, furrieFrame, leeFrame, jacksonFrame, pateFrame, pussoliniFrame);
                selected = selectPj(pussoliniFrame, "pussolini");
            }
        });

        stage.addActor(gokuFrame);
        stage.addActor(furrieFrame);
        stage.addActor(leeFrame);
        stage.addActor(jacksonFrame);
        stage.addActor(pateFrame);
        stage.addActor(pussoliniFrame);


    }

    @Override
    public void render(float delta) {
        if (Cosingas.renderizador.irAPantallaJuego) {
            setScreen(new GameScreen(game));
        }

        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);
        stage.getBatch().end();
        stage.act(delta);
        stage.draw();
    }

    //metodo para cargar los sprites cuando se seleccionan
    public void showPj(MyStage stage, String frame) {
        if (pj.getStage() != null) pj.remove();
        pj = new Image(new Texture("Selection/" + frame));
        pj.setPosition(72, 131);
        pj.setSize(304, 426);
        stage.addActor(pj);
    }

    public boolean selectPj(BaseImageButton frame, String framename) {
        frame.getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture(framename + "Selected.png")));
        return true;
    }

    public boolean unselectPjs(BaseImageButton goku, BaseImageButton curie, BaseImageButton lee, BaseImageButton jackson, BaseImageButton pate, BaseImageButton puss) {
        goku.getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture("gokuSelection.png")));
        curie.getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture("furrieSelection.png")));
        lee.getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture("leeSelection.png")));
        jackson.getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture("miauchaelSelection.png")));
        pate.getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture("pateSelection.png")));
        puss.getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture("pussoliniSelection.png")));
        return false;
    }
}
