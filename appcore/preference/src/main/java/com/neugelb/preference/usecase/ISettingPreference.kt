package com.neugelb.preference.usecase

import com.neugelb.core.model.ThemeMode

/**
 * Created By Rafiqul Hasan
 */
interface ISettingPreference {
	suspend fun getSelectedThemeMode(default: ThemeMode): ThemeMode
	suspend fun saveThemeModePreference(themeMode: ThemeMode)
}