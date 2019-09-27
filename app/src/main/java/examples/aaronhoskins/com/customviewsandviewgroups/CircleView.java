package examples.aaronhoskins.com.customviewsandviewgroups;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class CircleView extends View implements View.OnClickListener {
    private int radius;
    private int fillColor;
    private int xPosition;
    private int yPosition;
    private boolean isVisible = true;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final TypedArray typedArray
                = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        radius = typedArray.getInt(R.styleable.CircleView_radius, 30);
        fillColor = typedArray.getColor(R.styleable.CircleView_fillColor, 0);
        xPosition = typedArray.getInt(R.styleable.CircleView_xPosition, 50);
        yPosition = typedArray.getInt(R.styleable.CircleView_yPosition, 50);
        typedArray.recycle();
        setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(fillColor);
        if(radius > 500) {
            radius = 500;
        }
        canvas.drawCircle(xPosition, yPosition, radius,paint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getFillColor() {
        return fillColor;
    }

    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    @Override
    public void onClick(View view) {
        isVisible = !isVisible;
        setVisibility(isVisible ? VISIBLE : INVISIBLE);
    }
}
