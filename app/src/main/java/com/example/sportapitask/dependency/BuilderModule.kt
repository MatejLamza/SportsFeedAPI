package com.example.sportapitask.dependency

import com.example.sportapitask.view.ui.MainActivity
import com.example.sportapitask.view.ui.ActivityFeed
import com.example.sportapitask.viewmodels.modules.FeedModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(FeedModule::class))
    abstract fun bindsFeedActivity():ActivityFeed

    @ContributesAndroidInjector(modules = arrayOf(FeedModule::class))
    abstract fun bindsMainActivity(): MainActivity
}