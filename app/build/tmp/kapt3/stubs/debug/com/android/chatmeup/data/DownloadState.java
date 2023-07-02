package com.android.chatmeup.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/android/chatmeup/data/DownloadState;", "", "()V", "Downloaded", "Downloading", "NotDownloaded", "OnQueue", "Lcom/android/chatmeup/data/DownloadState$Downloaded;", "Lcom/android/chatmeup/data/DownloadState$Downloading;", "Lcom/android/chatmeup/data/DownloadState$NotDownloaded;", "Lcom/android/chatmeup/data/DownloadState$OnQueue;", "app_debug"})
public abstract class DownloadState {
    
    private DownloadState() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/data/DownloadState$NotDownloaded;", "Lcom/android/chatmeup/data/DownloadState;", "()V", "app_debug"})
    public static final class NotDownloaded extends com.android.chatmeup.data.DownloadState {
        @org.jetbrains.annotations.NotNull
        public static final com.android.chatmeup.data.DownloadState.NotDownloaded INSTANCE = null;
        
        private NotDownloaded() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/data/DownloadState$OnQueue;", "Lcom/android/chatmeup/data/DownloadState;", "()V", "app_debug"})
    public static final class OnQueue extends com.android.chatmeup.data.DownloadState {
        @org.jetbrains.annotations.NotNull
        public static final com.android.chatmeup.data.DownloadState.OnQueue INSTANCE = null;
        
        private OnQueue() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/android/chatmeup/data/DownloadState$Downloading;", "Lcom/android/chatmeup/data/DownloadState;", "progress", "", "(D)V", "getProgress", "()D", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Downloading extends com.android.chatmeup.data.DownloadState {
        private final double progress = 0.0;
        
        @org.jetbrains.annotations.NotNull
        public final com.android.chatmeup.data.DownloadState.Downloading copy(double progress) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public Downloading(double progress) {
            super();
        }
        
        public final double component1() {
            return 0.0;
        }
        
        public final double getProgress() {
            return 0.0;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/data/DownloadState$Downloaded;", "Lcom/android/chatmeup/data/DownloadState;", "()V", "app_debug"})
    public static final class Downloaded extends com.android.chatmeup.data.DownloadState {
        @org.jetbrains.annotations.NotNull
        public static final com.android.chatmeup.data.DownloadState.Downloaded INSTANCE = null;
        
        private Downloaded() {
            super();
        }
    }
}