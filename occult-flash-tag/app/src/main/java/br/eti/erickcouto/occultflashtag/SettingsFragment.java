package br.eti.erickcouto.occultflashtag;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

//import android.preference.EditTextPreference;
//import android.preference.Preference;
//import android.preference.PreferenceFragment;

import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat  {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //addPreferencesFromResource(R.xml.preferences);

        EditTextPreference editText = (EditTextPreference) this.findPreference("interval");
        editText.setSummary(editText.getText());

        editText.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                // do whatever you want with new value
                //EditTextPreference editText = (EditTextPreference) this.findPreference("interval");
                ((EditTextPreference)preference).setSummary(newValue.toString());
                // true to update the state of the Preference with the new value
                // in case you want to disallow the change return false
                return true;
            }
                    }
        );

//        ViewCompat.setOnApplyWindowInsetsListener(getActivity().findViewById(R.id.pref_fragment), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//
////            WindowCompat.getInsetsController(getActivity().getWindow(), getActivity().getWindow().getDecorView())
////                    .setAppearanceLightStatusBars(true);
//
//            return insets;
//        });


    }

    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

}