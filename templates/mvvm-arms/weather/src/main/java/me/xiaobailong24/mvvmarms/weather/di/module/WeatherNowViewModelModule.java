package <%= appPackage %>.weather.di.module;

import android.arch.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import <%= appPackage %>.di.scope.ViewModelScope;
import <%= appPackage %>.weather.mvvm.viewmodel.WeatherNowViewModel;

/**
 * @author xiaobailong24
 * @date 2017/6/16
 * Dagger WeatherNowViewModelModule
 * 包含ViewModelFactoryModule提供ViewModelProvider.Factory
 */
@Module
public abstract class WeatherNowViewModelModule {

    @Binds
    @IntoMap
    @ViewModelScope(WeatherNowViewModel.class)
    abstract ViewModel bindWeatherNowViewModel(WeatherNowViewModel weatherNowViewModel);
}
