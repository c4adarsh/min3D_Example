package my.blogspot.ubuntuanakramli.min3dtutorial;

import android.view.MotionEvent;

import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.parser.IParser;
import min3d.parser.Parser;
import min3d.vos.Light;
import min3d.vos.Number3d;

public class Obj3DView extends RendererActivity {

    float startX = 0;
    float startY = 0;
    float movedX = 0;
    float movedY = 0;
    private Object3dContainer cubeObject3D;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void initScene() {
        /*Light myLight = new Light();
        myLight.position.setZ(150);
        myLight.position.setX(150);
        myLight.position.setY(150);*/
//        scene.lights().add(new Light());
//        scene.lights().add(new Light());

        Light myLight1 = new Light();
        myLight1.position.setX(180);
        myLight1.position.setY(0);
        myLight1.position.setZ(0);
        scene.lights().add(myLight1);

        Light myLight = new Light();
        myLight.position.setX(0);
        myLight.position.setY(0);
        myLight.position.setZ(180);
        scene.lights().add(myLight);


        Light myLight2 = new Light();
        myLight2.position.setX(0);
        myLight2.position.setY(180);
        myLight2.position.setZ(0);
        scene.lights().add(myLight2);

        //scene.lights().add(new Light());
//        Light light = new Light();
//        light.position.setAllFrom(new Number3d(0,0,50));
//        scene.lights().add(light);
//        scene.lights().add(new Light());
//        scene.lights().add(new Light());

        scene.backgroundColor().setAll(0xff444444);


        IParser myParser = Parser.createParser(Parser.Type.OBJ, getResources(), "my.blogspot" +
                ".ubuntuanakramli.min3dtutorial:raw/cube_obj", true);
        myParser.parse();
        cubeObject3D = myParser.getParsedObject();
        cubeObject3D.position().x = cubeObject3D.position().z = 0;
        cubeObject3D.position().y = -2;
        // Depending on the model you will need to change the scale
        cubeObject3D.scale().x = cubeObject3D.scale().y = cubeObject3D.scale().z = .0024f;
        scene.addChild(cubeObject3D);
    }

    @Override
    public void updateScene() {
//        cubeObject3D.rotation().x += 0.5;
//        cubeObject3D.rotation().z += 1;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_UP) {
            startX = 0;
            startY = 0;
            movedX = 0;
            movedY = 0;
        }

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            startX = event.getRawX();
            startY = event.getRawY();
        }

        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            movedX = event.getRawX() - startX;
            movedY = event.getRawY() - startY;

            if (movedX > 0) {
                cubeObject3D.rotation().y += movedX/20;
            } else {
                cubeObject3D.rotation().y += movedX/20;
            }
        }


        return super.onTouchEvent(event);
    }
}