package com.neugelb.setting.domain.usecase

import com.neugelb.setting.domain.model.ThemeModel
import com.neugelb.setting.domain.repository.ISettingRepository
import javax.inject.Inject

/**
 * Created By Rafiqul Hasan
 */
class SettingUseCaseImpl @Inject constructor(private val repository: ISettingRepository) :
	ISettingUseCase {
	override fun getAvailableThemeMode(): List<ThemeModel> {
		return repository.getAvailableThemeMode()
	}
}