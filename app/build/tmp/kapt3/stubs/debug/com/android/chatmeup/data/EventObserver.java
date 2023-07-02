package com.android.chatmeup.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/android/chatmeup/data/EventObserver;", "T", "Landroidx/lifecycle/Observer;", "Lcom/android/chatmeup/data/Event;", "onEventUnhandledContent", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "onChanged", "value", "app_debug"})
public final class EventObserver<T extends java.lang.Object> implements androidx.lifecycle.Observer<com.android.chatmeup.data.Event<? extends T>> {
    private final kotlin.jvm.functions.Function1<T, kotlin.Unit> onEventUnhandledContent = null;
    
    public EventObserver(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> onEventUnhandledContent) {
        super();
    }
    
    @java.lang.Override
    public void onChanged(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.Event<? extends T> value) {
    }
}