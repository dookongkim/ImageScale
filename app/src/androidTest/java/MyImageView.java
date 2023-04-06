import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import com.example.imagescale.R;

//commit1 - 기본 설계 완료
//commit2 - 기능1완성
//commit3 - 홍길동 기능 2 추가
//commit4 - 구현 완료


public class MyImageView extends View {
    Drawable image;
    float scale = 1f;
    ScaleGestureDetector gestureDetector;

    public MyImageView(Context context) {
        super(context);
        image=context.getResources().getDrawable(R.drawable.starry_night);//res에서 image불러오기
        image.setBounds(0,0,image.getIntrinsicWidth(),image.getIntrinsicHeight());//이미지의 크기 설정
        gestureDetector = new ScaleGestureDetector(context,new ScaleListener());//멤버필드에 저장

    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();  // 현재 캔버스 상태 저장
        canvas.scale(scale,scale);
        image.draw(canvas);
        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);

        return true;
    }

    class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public boolean onScale(ScaleGestureDetector detector) {
            scale= scale * detector.getScaleFactor();
            if(scale>=10.0f)
                scale=10f;
            if(scale<=0.1f)
                scale=0.1f;  // 너무 크거나 작으면 보정

            return true;
        }
    }
}
