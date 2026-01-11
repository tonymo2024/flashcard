# ProGuard rules for the flashcard application

# Keep the application class
-keep class com.flashcardkids.FlashcardApplication { *; }

# Keep all entities
-keep class com.flashcardkids.data.local.entity.** { *; }

# Keep all DAOs
-keep interface com.flashcardkids.data.local.dao.** { *; }

# Keep all repositories
-keep class com.flashcardkids.data.repository.** { *; }

# Keep all ViewModels
-keep class com.flashcardkids.viewmodel.** { *; }

# Keep all UI components
-keep class com.flashcardkids.ui.components.** { *; }

# Keep all screens
-keep class com.flashcardkids.ui.screens.** { *; }

# Keep all utility classes
-keep class com.flashcardkids.util.** { *; }

# Keep all navigation classes
-keep class com.flashcardkids.ui.navigation.** { *; }

# Keep all dependency injection classes
-keep class com.flashcardkids.di.** { *; }

# Keep all data classes
-keep class com.flashcardkids.data.** { *; }

# Keep all generated classes
-keep class * extends androidx.room.RoomDatabase { *; }
-keep class * extends androidx.room.Entity { *; }
-keep class * extends androidx.room.Dao { *; }

# Keep all Parcelable classes
-keepclassmembers class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

# Keep all annotations
-keepattributes *Annotation*