package bornbaby.com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by madhu on 30-Dec-17.
 */

public class Utility {

    public static void setTranslateStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Utility.getColor(activity, R.color.transparent));
        }
    }

    @SuppressWarnings("deprecation")
    public static int getColor(Context context, int id) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 23)
            return ContextCompat.getColor(context, id);
        else
            return context.getResources().getColor(id);
    }

    public static int getStatusBarHeight(Activity activity) {
        int height;

        Resources myResources = activity.getResources();
        int idStatusBarHeight = myResources.getIdentifier(
                "status_bar_height", "dimen", "android");
        if (idStatusBarHeight > 0) {
            height = activity.getResources().getDimensionPixelSize(idStatusBarHeight);
            Toast.makeText(activity,
                    "Status Bar Height = " + height,
                    Toast.LENGTH_LONG).show();
        } else {
            height = 0;
            Toast.makeText(activity,
                    "Resources NOT found",
                    Toast.LENGTH_LONG).show();
        }

        return height;
    }


}
