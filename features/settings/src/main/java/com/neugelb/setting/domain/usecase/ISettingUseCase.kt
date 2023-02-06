package com.neugelb.setting.domain.usecase

import com.neugelb.setting.domain.model.ThemeModel

/**
 * Created By Rafiqul Hasan
 */
interface ISettingUseCase {
	fun getAvailableThemeMode(): List<ThemeModel>
}