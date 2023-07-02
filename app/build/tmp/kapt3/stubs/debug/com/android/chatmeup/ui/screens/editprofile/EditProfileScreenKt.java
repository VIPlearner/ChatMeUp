package com.android.chatmeup.ui.screens.editprofile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aN\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\f\u001a\u00020\u0001H\u0007\u001a2\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u00ee\u0001\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"MAX_ABOUT_STR_LENGTH", "", "MAX_DISPLAY_NAME_LENGTH", "EditDisplayNameDialog", "", "onDismissButtonClicked", "Lkotlin/Function0;", "onConfirm", "Lkotlin/Function1;", "", "displayName", "onValueChanged", "textLengthRemaining", "EditProfileScreen", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "onBackClick", "editProfileViewModel", "Lcom/android/chatmeup/ui/screens/editprofile/viewmodel/EditProfileViewModel;", "SheetLayout", "scope", "Lkotlinx/coroutines/CoroutineScope;", "currentScreen", "Lcom/android/chatmeup/ui/screens/editprofile/BottomSheetScreen;", "modalBottomSheetState", "Landroidx/compose/material/ModalBottomSheetState;", "displayNameTextLengthRemaining", "onDisplayNameChanged", "onConfirmDisplayName", "aboutStr", "aboutTextLengthRemaining", "onAboutStrChanged", "onConfirmAbout", "onTakePictureClicked", "onUploadFromStorageClicked", "onConfirmProfileImage", "", "onRotateProfileImage", "onCloseImagePage", "app_debug"})
public final class EditProfileScreenKt {
    public static final int MAX_DISPLAY_NAME_LENGTH = 25;
    public static final int MAX_ABOUT_STR_LENGTH = 140;
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class, androidx.compose.material.ExperimentalMaterialApi.class, androidx.compose.ui.ExperimentalComposeUiApi.class})
    public static final void EditProfileScreen(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.editprofile.viewmodel.EditProfileViewModel editProfileViewModel) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.ui.ExperimentalComposeUiApi.class, androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void EditDisplayNameDialog(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissButtonClicked, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onConfirm, @org.jetbrains.annotations.NotNull
    java.lang.String displayName, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValueChanged, int textLengthRemaining) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material.ExperimentalMaterialApi.class})
    public static final void SheetLayout(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.editprofile.BottomSheetScreen currentScreen, @org.jetbrains.annotations.NotNull
    androidx.compose.material.ModalBottomSheetState modalBottomSheetState, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.NotNull
    java.lang.String displayName, int displayNameTextLengthRemaining, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDisplayNameChanged, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onConfirmDisplayName, @org.jetbrains.annotations.NotNull
    java.lang.String aboutStr, int aboutTextLengthRemaining, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onAboutStrChanged, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onConfirmAbout, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onTakePictureClicked, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onUploadFromStorageClicked, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onConfirmProfileImage, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onRotateProfileImage, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onCloseImagePage) {
    }
}