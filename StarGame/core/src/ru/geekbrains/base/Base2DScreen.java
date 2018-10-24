package ru.geekbrains.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Application.ApplicationType;



public class Base2DScreen implements Screen, InputProcessor {

    @Override
        public void show() {
            System.out.println("show");
               Gdx.input.setInputProcessor(this);
        }

        @Override
        public void render(float delta) {

        }

        @Override
        public void resize(int width, int height) {
            System.out.println("resize w = " + width + " h = " + height);
        }

        @Override
        public void pause() {
            System.out.println("pause");
        }

        @Override
        public void resume() {
            System.out.println("resume");
        }

        @Override
        public void hide() {
            System.out.println("hide");
            Gdx.input.setInputProcessor(null);
            dispose();
        }

        @Override
        public void dispose() {
            System.out.println("dispose");
            Gdx.input.setInputProcessor(null);
        }

        @Override
        public boolean keyDown(int keycode) {
            System.out.println("keyDown keycode = " + keycode);
            return true;
        }

        @Override
        public boolean keyUp(int keycode) {
            System.out.println("keyUp keycode = " + keycode);
            return true;
        }

        @Override
        public boolean keyTyped(char character) {
            System.out.println("keyTyped character = " + character);
            return false;
        }


        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            System.out.println("touchDown screenX = " + screenX + " screenY = " + screenY);
            if (!Gdx.app.getType().equals(ApplicationType.Android))
                return false;
            return true;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            System.out.println("touchUp screenX = " + screenX + " screenY = " + screenY);
            if (!Gdx.app.getType().equals(ApplicationType.Android))
                return false;


            return true;
        }

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            System.out.println("touchDragged screenX = " + screenX + " screenY = " + screenY);

            return false;
        }
    public boolean touchMoved(int screenX, int screenY) {
        return false;
    }


    @Override
        public boolean mouseMoved(int screenX, int screenY) {
            return true;
        }

        @Override
        public boolean scrolled(int amount) {
            System.out.println("scrolled");
            return false;
        }

    }