package com.example.raf0c.fallingwordsgame;

import android.content.ComponentName;

import com.example.raf0c.fallingwordsgame.service.BackgroundMusicService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by raf0c on 14/08/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 22)
public class MainActivityTest {

    private MainActivity mMainActivity;

    @Before
    public void setUp() throws Exception {

        BackgroundMusicService.BackgroundMusicServiceBinder mStubBinder = PowerMockito.mock(BackgroundMusicService.BackgroundMusicServiceBinder.class);
        PowerMockito.when(mStubBinder.getService()).thenReturn(PowerMockito.mock(BackgroundMusicService.class));
        ShadowApplication.getInstance().setComponentNameAndServiceForBindService(new ComponentName("com.example.raf0c.myfallingwordstest","BackgroundMusicService"), mStubBinder);

        mMainActivity = Robolectric.buildActivity(MainActivity.class).create().get();

    }

    @Test
    public void mainActivityShouldNotBeNull() throws Exception {
        assertNotNull(mMainActivity);
    }

    @Test
    public void clickStartShouldStartGameActivity() throws Exception {
        mMainActivity.onStartRequested("Rafael");
        assertNotNull(ShadowApplication.getInstance().getNextStartedActivity());
    }

    //TODO Test proper view?

}
