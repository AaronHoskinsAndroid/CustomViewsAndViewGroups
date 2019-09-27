package examples.aaronhoskins.com.customviewsandviewgroups;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class CompoundView extends LinearLayout implements View.OnClickListener {
    TextView tvLike;
    TextView tvDislike;
    int likeCount = 0 ;
    int dislikeCount = 0;

    public CompoundView(Context context) {
        this(context, null);
    }

    public CompoundView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CompoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init() {
        inflate(getContext(), R.layout.compond_view, this);
        tvLike = findViewById(R.id.tvLike);
        tvDislike = findViewById(R.id.tvdislike);
        tvLike.setOnClickListener(this);
        tvDislike.setOnClickListener(this);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CompoundView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.tvLike:
                incrementLikes();
                break;
            case R.id.tvdislike:
                incrementDislikes();
                break;
        }
    }

    public void incrementLikes() {
        setLikeCount(likeCount+=1);

    }

    public void incrementDislikes() {
        setDislikeCount(dislikeCount+=1);
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
        tvLike.setText(String.valueOf(likeCount));
    }

    public int getDislikeCount() {
        return dislikeCount;

    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
        tvDislike.setText(String.valueOf(dislikeCount));
    }
}
