package com.example.sportapitask.dependency

import com.example.sportapitask.view.ui.fragments.FragmentAthlete
import com.example.sportapitask.view.ui.fragments.FragmentFeed
import com.example.sportapitask.viewmodels.modules.AthleteModule
import com.example.sportapitask.viewmodels.modules.FeedModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {
    @ContributesAndroidInjector(modules = arrayOf(FeedModule::class))
    abstract fun bindsFeedFragment(): FragmentFeed

    @ContributesAndroidInjector(modules = arrayOf(AthleteModule::class))
    abstract fun bindsAthleteFragment(): FragmentAthlete
}