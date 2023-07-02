package com.android.chatmeup.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0017\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0004J\r\u0010\b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\tR\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/android/chatmeup/data/Event;", "T", "", "content", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "isHandled", "", "getContentIfNotHandled", "()Ljava/lang/Object;", "app_debug"})
public class Event<T extends java.lang.Object> {
    private final T content = null;
    private boolean isHandled = false;
    
    public Event(T content) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final T getContentIfNotHandled() {
        return null;
    }
}