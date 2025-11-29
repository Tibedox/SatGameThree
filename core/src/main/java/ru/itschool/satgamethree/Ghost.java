package ru.itschool.satgamethree;

import static ru.itschool.satgamethree.Main.*;

import com.badlogic.gdx.math.MathUtils;

public class Ghost {
    float x, y;
    float width, height;
    private float stepX, stepY;

    public Ghost() {
        x = 100;
        y = 200;
        width = MathUtils.random(50,300);
        height = width*1.5f;
        stepX = MathUtils.random(-5f, 5f);
        stepY = MathUtils.random(-5f, 5f);
    }

    void move() {
        x = x + stepX;
        y = y + stepY;

        outOfBounds1();
    }

    void outOfBounds1() {
        if (x > screenWidth - width || x < 0) {
            stepX = -stepX;
        }
        if (y > screenHeight - height || y < 0) {
            stepY = -stepY;
        }
    }

    void outOfBounds2() {
        if (x > screenWidth) {
            x = -width;
        }
        if (x < -width) {
            x = screenWidth;
        }
        if (y > screenHeight) {
            y = -height;
        }
        if (y < -height) {
            y = screenHeight;
        }
    }

    void hit(float tx, float ty){
        if(x < tx && tx < x+width && y < ty && ty < y+height){
            x = -10000;
            stepX = 0;
            stepY = 0;
        }
    }
}
