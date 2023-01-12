package com.victorrubia.tfg.presentation.di.measuring_menu

import com.victorrubia.tfg.domain.usecase.EndActivityUseCase
import com.victorrubia.tfg.domain.usecase.EndPPGMeasureUseCase
import com.victorrubia.tfg.domain.usecase.GetCurrentActivityUseCase
import com.victorrubia.tfg.domain.usecase.SavePPGMeasureUseCase
import com.victorrubia.tfg.presentation.measuring_menu.MeasuringMenuActivity
import com.victorrubia.tfg.presentation.measuring_menu.MeasuringMenuViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Dagger module to provide the [MeasuringMenuActivity] dependencies.
 */
@Module
class MeasuringMenuModule {

    /**
     * Provides the [MeasuringMenuViewModelFactory] instance.
     *
     * @param getCurrentActivityUseCase The [GetCurrentActivityUseCase] instance.
     * @param savePPGMeasureUseCase The [SavePPGMeasureUseCase] instance.
     * @param endPPGMeasureUseCase The [EndPPGMeasureUseCase] instance.
     * @param endActivityUseCase The [EndActivityUseCase] instance.
     * @return The [MeasuringMenuViewModelFactory] instance.
     */
    @MeasuringMenuScope
    @Provides
    fun provideMeasuringMenuViewModelFactory(endActivityUseCase: EndActivityUseCase,
                                             getCurrentActivityUseCase: GetCurrentActivityUseCase,
                                             savePPGMeasureUseCase: SavePPGMeasureUseCase,
                                             endPPGMeasureUseCase: EndPPGMeasureUseCase) : MeasuringMenuViewModelFactory{
        return MeasuringMenuViewModelFactory(endActivityUseCase, getCurrentActivityUseCase, savePPGMeasureUseCase, endPPGMeasureUseCase)
    }

}