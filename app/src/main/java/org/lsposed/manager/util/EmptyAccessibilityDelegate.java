/*
 * This file is part of LSPosed.
 *
 * LSPosed is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * LSPosed is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LSPosed.  If not, see <https://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2022 LSPosed Contributors
 */

package org.lsposed.manager.util;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

import androidx.annotation.NonNull;

public class EmptyAccessibilityDelegate extends View.AccessibilityDelegate {

    @Override
    public void sendAccessibilityEvent(@NonNull View host, int eventType) {

    }

    @Override
    public boolean performAccessibilityAction(@NonNull View host, int action, Bundle args) {
        return true;
    }

    @Override
    public void sendAccessibilityEventUnchecked(@NonNull View host, @NonNull AccessibilityEvent event) {

    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(@NonNull View host, @NonNull AccessibilityEvent event) {
        return true;
    }

    @Override
    public void onPopulateAccessibilityEvent(@NonNull View host, @NonNull AccessibilityEvent event) {

    }

    @Override
    public void onInitializeAccessibilityEvent(@NonNull View host, @NonNull AccessibilityEvent event) {

    }

    @Override
    public void onInitializeAccessibilityNodeInfo(@NonNull View host, @NonNull AccessibilityNodeInfo info) {

    }

    @Override
    public void addExtraDataToAccessibilityNodeInfo(@NonNull View host, @NonNull AccessibilityNodeInfo info, @NonNull String extraDataKey, Bundle arguments) {

    }

    @Override
    public boolean onRequestSendAccessibilityEvent(@NonNull ViewGroup host, @NonNull View child, @NonNull AccessibilityEvent event) {
        return true;
    }

    @Override
    public AccessibilityNodeProvider getAccessibilityNodeProvider(@NonNull View host) {
        return null;
    }
}
