package ru.itschool.satgamethree;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    static float screenWidth = 1280, screenHeight = 720;
    private SpriteBatch batch;
    private Texture image;
    private Ghost[] ghost = new Ghost[55];
    Vector3 touch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        touch = new Vector3();
        image = new Texture("ghost.png");
        for (int i = 0; i < ghost.length; i++) {
            ghost[i] = new Ghost();
        }
    }

    @Override
    public void render() {
        // касания
        if (Gdx.input.justTouched()){
            float x = Gdx.input.getX();
            float y = Gdx.input.getY();
            for(int i=0; i<ghost.length; i++) {
                ghost[i].hit(x, y);
            }
        }

        // игровые события
        for(int i=0; i<ghost.length; i++) {
            ghost[i].move();
        }

        // отрисовка
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        for(int i=0; i<ghost.length; i++) {
            batch.draw(image, ghost[i].x, ghost[i].y, ghost[i].width, ghost[i].height);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
