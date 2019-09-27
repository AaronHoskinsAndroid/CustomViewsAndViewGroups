package examples.aaronhoskins.com.customviewsandviewgroups;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
    CircleView circleView;
    CompoundView compoundView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleView = findViewById(R.id.cirCustomView);
        compoundView = findViewById(R.id.cvLikes);
        compoundView.setLikeCount(100);
        compoundView.setDislikeCount(1000);

        Animation circleAnimation
                = AnimationUtils.loadAnimation(
                        this, R.anim.circle_animation);
        circleView.setAnimation(circleAnimation);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.circle_animation, R.anim.circle_animation);
    }
}
