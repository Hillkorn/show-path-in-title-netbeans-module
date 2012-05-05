/**
 * Copyright 2012 markiewb
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.markiewb.netbeans.plugin.showpathintitle;

import java.util.prefs.Preferences;
import org.openide.util.NbPreferences;

/**
 * Simple POJO for loading/saving options. Note: No setter/getter were
 * introduced for the ease of usage. It is a plain data holder.
 *
 * @author markiewb
 */
public class ShowPathInTitleOptions {

    public static final String SHOWFILENAME = "showFileName";
    public static final String SHOWIDEVERSION = "showIDEVersion";
    public static final String SHOWPROJECTNAME = "showProjectName";
    public static final String SHOWRELATIVEFILENAME = "showRelativeFilename";
    public static final String USENODEASREFERENCE = "useNodeAsReference";
    public static final String USEEDITORASREFERENCE = "useEditorAsReference";

    private ShowPathInTitleOptions() {
        //NOP
    }
    public boolean showProjectName;
    public boolean showFileName;
    public boolean showIDEVersion;
    public boolean showRelativeFilename;
    public boolean useNodeAsReference;
    public boolean useEditorAsReference;

    public static ShowPathInTitleOptions load() {
        Preferences pref = NbPreferences.forModule(ShowPathInTitleOptions.class);

        ShowPathInTitleOptions options = new ShowPathInTitleOptions();
        options.showProjectName = pref.getBoolean(SHOWPROJECTNAME, true);
        options.showFileName = pref.getBoolean(SHOWFILENAME, true);
        options.showIDEVersion = pref.getBoolean(SHOWIDEVERSION, true);
        options.showRelativeFilename = pref.getBoolean(SHOWRELATIVEFILENAME, false);
        options.useNodeAsReference = pref.getBoolean(USENODEASREFERENCE, true);
        options.useEditorAsReference = pref.getBoolean(USEEDITORASREFERENCE, false);
        return options;
    }

    public void save() {
        Preferences pref = NbPreferences.forModule(ShowPathInTitleOptions.class);
        pref.putBoolean(SHOWPROJECTNAME, showProjectName);
        pref.putBoolean(SHOWFILENAME, showFileName);
        pref.putBoolean(SHOWIDEVERSION, showIDEVersion);
        pref.putBoolean(SHOWRELATIVEFILENAME, showRelativeFilename);
        pref.putBoolean(USENODEASREFERENCE, useNodeAsReference);
        pref.putBoolean(USEEDITORASREFERENCE, useEditorAsReference);
    }

    public void reset() {
        showProjectName = true;
        showFileName = true;
        showIDEVersion = true;
        showRelativeFilename = false;
        useNodeAsReference = true;
        useEditorAsReference = false;
    }
}
