package ru.geekbrains.screen;

import ru.geekbrains.base.Base2DScreen;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Button;


import javax.swing.text.View;


public class MenuScreen extends Base2DScreen {


    private SpriteBatch batch;
    private Texture img;

    private Vector2 pos;
    private Vector2 v;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        pos = new Vector2(0,0);
        v = new Vector2(0.5f,0.3f);
        touch = new Vector2(0,0);
        buf = new Vector2();
    }
     
    @Override
    public void render(float delta) {
      super.render(delta);
        Gdx.gl.glClearColor(0.28f, 0, 0.30f, 0.25f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        buf.set(touch);
        if(buf.set(pos).len() > v.len()) {
            pos.add(v);
        } else {
            pos.set(touch);
        }
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
    }    

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
      touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(touch.cpy().sub(pos).setLength(0.5f));
        return false;

    }
}


