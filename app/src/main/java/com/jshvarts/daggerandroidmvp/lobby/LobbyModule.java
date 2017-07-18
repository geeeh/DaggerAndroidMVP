package com.jshvarts.daggerandroidmvp.lobby;

import com.jshvarts.daggerandroidmvp.common.CommonGreetingUseCase;
import com.jshvarts.daggerandroidmvp.rx.SchedulersFacade;

import dagger.Module;
import dagger.Provides;

/**
 * Define LobbyActivity-specific dependencies here.
 */
@Module
public class LobbyModule {

    @Provides
    LobbyGreetingRepository provideLobbyGreetingRepository() {
        return new LobbyGreetingRepository();
    }

    @Provides
    LobbyPresenter provideLobbyPresenter(LobbyGreetingContract.LobbyView lobbyView,
                                         CommonGreetingUseCase commonGreetingUseCase,
                                         LobbyGreetingUseCase lobbyGreetingUseCase,
                                         SchedulersFacade schedulersFacade) {
        return new LobbyPresenter(lobbyView, commonGreetingUseCase, lobbyGreetingUseCase, schedulersFacade);
    }
}
