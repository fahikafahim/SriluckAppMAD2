//package com.example.sriluckplatform.screens
//
//import android.app.Activity
//import android.content.Context
//import android.content.Intent
//import android.net.Uri
//import android.provider.MediaStore
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.platform.LocalContext
//import androidx.core.content.FileProvider
//import java.io.File
//
//@Composable
//fun rememberImagePicker(): Pair<Uri?, () -> Unit> {
//    var imageUri by remember { mutableStateOf<Uri?>(null) }
//    val context = LocalContext.current
//
//    val galleryLauncher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.GetContent(),
//        onResult = { uri -> imageUri = uri }
//    )
//
//    val cameraLauncher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.TakePicture(),
//        onResult = { success ->
//            if (success) imageUri?.let { uri ->
//                // Image captured successfully
//            }
//        }
//    )
//
//    fun pickImage() {
//        imageUri = createImageUri(context)
//        cameraLauncher.launch(imageUri)
//    }
//
//    return Pair(imageUri, ::pickImage)
//}
//
//private fun createImageUri(context: Context): Uri? {
//    val imageFile = File.createTempFile(
//        "profile_${System.currentTimeMillis()}",
//        ".jpg",
//        context.externalCacheDir
//    )
//    return FileProvider.getUriForFile(
//        context,
//        "${context.packageName}.fileprovider",
//        imageFile
//    )
//}