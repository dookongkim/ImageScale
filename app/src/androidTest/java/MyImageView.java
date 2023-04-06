import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

//commit1 - 기본 설계 완료
//commit2 - 기능1완성


public class MyImageView extends View {
    Drawable image;
    float scale = 1f;


    public MyImageView(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }

    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public boolean onScale(ScaleGestureDetector detector) {

            return true;
    }
    }

}
