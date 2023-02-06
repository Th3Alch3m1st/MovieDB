package com.neugelb.setting.domain.repository

import com.neugelb.setting.domain.model.ThemeModel

/**
 * Created By Rafiqul Hasan
 */
interface ISettingRepository {
	fun getAvailableThemeMode(): List<ThemeModel>
}