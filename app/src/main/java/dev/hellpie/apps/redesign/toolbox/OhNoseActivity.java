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

import android.app.WallpaperManager;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class OhNoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        applyLandscapeShadow();
    }


    private void applyLandscapeShadow() {
        Drawable wallpaper = WallpaperManager.getInstance(this).getDrawable();
        wallpaper.setColorFilter(0xff777777, PorterDuff.Mode.MULTIPLY);

        ImageView background = (ImageView) findViewById(R.id.window_background);
        if (background != null) {
            background.setImageDrawable(wallpaper);
        }
    }
}
