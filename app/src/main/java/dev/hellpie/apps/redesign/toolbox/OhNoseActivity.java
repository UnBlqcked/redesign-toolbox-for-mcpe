/*
 * Copyright 2016 Diego Rossi (@_HellPie)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package dev.hellpie.apps.redesign.toolbox;

import android.annotation.TargetApi;
import android.app.WallpaperManager;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class OhNoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        // Fuck the 1 API level Toolbox misses, user gets dark grey on obsolete pieces of shit.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) applyLandscapeShadow();
    }

    /**
     * WARNING: Screen stays stretched because Wallpaper returns what is often
     * the current, portrait, orientation of the home screen. Too lazy to do the
     * cut and resize job, but should be easy with a Bitmap.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN) // Burn in hell Ice Crap Sandshit
    private void applyLandscapeShadow() {
        Drawable wallpaper = WallpaperManager.getInstance(this).getDrawable();
        wallpaper.setColorFilter(0xff777777, PorterDuff.Mode.MULTIPLY);

        View window = findViewById(R.id.__tmp_window__);
        if (window != null) {
            window.setBackground(wallpaper);
        }
    }
}
