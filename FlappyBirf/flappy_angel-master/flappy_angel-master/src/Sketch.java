import javafx.scene.layout.CornerRadii;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Sketch extends PApplet {
    float xpos = 200f;
    float ypos = 50f;
    float vy = 0f;
    float gravity = 0.4f; // нужно же учесть сопротивление воздуха и волю к жизни)
    PImage bird; // переменная для картинки
    PImage fon; // переменная для фона
    int count = 300; // счетчик перерисовок
    PImage wall; // переменная картинки для стен
    float[] wallOffset = new float[4];
    WallPair[] walls = new WallPair[4];
    boolean lose = false;
    int score = 0;
    PFont flappyFont;
    PImage reset;

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        smooth(); //сглаживание границ
        noStroke(); // не прорисовывается граница между изображениями
        bird = loadImage("bird1.png");
        fon = loadImage("back.png");
        wall = loadImage("truba.png");
        flappyFont = createFont("04B_19__.TTF", 50f, true);
        reset = loadImage("RestartBtn.png");
        for (int i = 0; i < wallOffset.length; i++) {
            wallOffset[i] = random(-100, 100);
        }
        fill(255);
        textFont(flappyFont);

    }

    public void draw() {
        // background(0); //цвет фона
        if (!lose) {
            count++;
        }
        if (count > width * 4) {
            count = 0;
        }
        drawBackgroundAndWalls(count % width); // рисует фон
        image(bird, xpos, ypos); // рисует птицу
        vy += gravity;
        ypos += vy;
        if (ypos > height - 40) {
            ypos = height - 40;
            //lose = true;
        } else if (ypos < 0) {
            ypos = 0;
            //lose  = true;
        }
        checkTouch();
        //if (count == width) count = 0;
        text("SCORE" + score, width - 200, 40);
        if (lose) {
            imageMode(CENTER);
            image(reset, width / 2, height / 2);
            imageMode(CORNER);
        }
    }

    public void drawBackgroundAndWalls(int offset) {

        image(fon, -offset, 0);
        image(fon, width - offset, 0);
        drawWalls(width - offset);
        if (count > 800) {
            drawWalls(-offset);
        }

    }

    public void drawWalls(int offset) {
        for (int i = 0; i < 4; i++) {
            drawPairOfWalls(offset + 200 * i, i, wallOffset[i]);
        }
    }

    void drawPairOfWalls(int xPos, int i, float offset) {
        pushMatrix();
        rotate(PI);
        image(wall, -xPos - 50, -200 - offset);
        popMatrix(); // поворот матрицы
        image(wall, xPos, height / 2 + 150 + offset);
        if (xPos > 0 && xPos < width) {
            walls[i] = new WallPair(xPos, 200 + offset, height / 2 + offset);
        }
        if (xPos == xpos - wall.width && !lose) {
            score++;
        }
    }

    void checkTouch() {
        for (WallPair pair : walls) {
            if (pair != null) {
                if ((ypos < pair.y1 && xpos > pair.x && xpos < pair.x + wall.width)
                        || (ypos > pair.y2 && xpos > pair.x && xpos < pair.x + wall.width)) {
                    println(ypos);
                    lose = true;
                }
            }
        }
    }


    public void keyPressed() {
        if (!lose) {
            vy *= -1.3f; //константа ускорения движения птицы
        } else {
            reset();
        }

    }

    void reset() {
        lose = false;
        count = 300;
        ypos = 50;
        score = 0;
        vy = 0;
        for (int i = 0; i < wallOffset.length; i++) {
            wallOffset[i] = random(-100, 100);
        }
    }


    public void keyReleased() {
        vy = gravity;
    }

    class WallPair {
        float x, y1, y2;

        WallPair(float x, float y1, float y2) {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
        }
    }
}

