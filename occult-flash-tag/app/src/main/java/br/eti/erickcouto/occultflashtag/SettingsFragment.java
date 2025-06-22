package br.eti.erickcouto.occultflashtag;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment  {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

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


    }

}