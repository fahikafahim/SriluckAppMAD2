package com.example.sriluckplatform.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.ui.draw.clip
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.example.sriluckplatform.R
import com.example.sriluckplatform.components.BottomBar
import com.example.sriluckplatform.components.TopBar
import com.example.sriluckplatform.data.Datasource

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.ui.graphics.painter.Painter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest


@Composable
fun ProfilePage(navController: NavController) {
    val user = Datasource.currentUser
    val context = LocalContext.current

    // State for the image URI
    val imageUri = remember { mutableStateOf<String?>(null) }

    // Permission state for reading external storage
//    val readPermissionState = rememberPermissionState(
//        Manifest.permission.READ_EXTERNAL_STORAGE
//    )

    // Launcher for image selection
    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            // Here you would typically upload the image to your server
            // and save the URI to your user data
            imageUri.value = it.toString()
        }
    }

    Scaffold(
        topBar = {
            TopBar(
                title = "Profile",
                showIcons = false
            )
        },
        bottomBar = {
            BottomBar(navController)
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            // Profile picture section
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                val painter: Painter = if (imageUri.value != null) {
                    rememberAsyncImagePainter(
                        ImageRequest.Builder(context)
                            .data(imageUri.value)
                            .build()
                    )
                } else {
                    painterResource(id = R.drawable.ic_launcher_background) // Your default profile image
                }

                Image(
                    painter = painter,
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                        .clickable {
//                            if (readPermissionState.hasPermission) {
//                                imagePicker.launch("image/*")
//                            } else {
//                                readPermissionState.launchPermissionRequest()
//                            }
                        },
                    contentScale = ContentScale.Crop
                )

                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Change profile picture",
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(6.dp),
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = user.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = user.email,
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(32.dp))

            ProfileMenuItem(
                icon = Icons.Default.Person,
                text = "Personal Information",
                onClick = { /* Handle click */ }
            )

            ProfileMenuItem(
                icon = Icons.Default.Edit,
                text = "Change Password",
                onClick = { /* Handle click */ }
            )

            ProfileMenuItem(
                icon = Icons.Default.ExitToApp,
                text = "Logout",
                onClick = { navController.navigate("login") }
            )
        }
    }
}

@Composable
fun ProfileMenuItem(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = text,
                fontSize = 16.sp
            )
        }
    }
}