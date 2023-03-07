package de.szalkowski.activitylauncher.rustore_fork.ui.activity;

import android.content.ComponentName;
import android.os.Bundle;
import android.widget.Toast;

import org.thirdparty.Launcher;

import de.szalkowski.activitylauncher.rustore_fork.R;
import de.szalkowski.activitylauncher.rustore_fork.util.Signer;

public class RootLauncherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Bundle bundle = getIntent().getExtras();
            if (bundle == null) {
                return;
            }

            String pkg = bundle.getString("pkg");
            String cls = bundle.getString("cls");
            String signature = bundle.getString("sign");

            var componentName = new ComponentName(pkg, cls);

            var signer = new Signer(getApplicationContext());
            if (signer.validateComponentNameSignature(componentName, signature)) {
                Launcher.launchActivity(getApplicationContext(), componentName, true, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), getText(R.string.error).toString() + ": " + e, Toast.LENGTH_LONG).show();
        } finally {
            finish();
        }
    }
}
