package com.flashcardkids.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.flashcardkids.ui.screens.AddCardScreen
import com.flashcardkids.ui.screens.AddDeckScreen
import com.flashcardkids.ui.screens.CardStudyScreen
import com.flashcardkids.ui.screens.DeckDetailScreen
import com.flashcardkids.ui.screens.DeckListScreen
import com.flashcardkids.ui.screens.HomeScreen
import com.flashcardkids.ui.screens.ProgressScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object DeckList : Screen("deck_list")
    object AddDeck : Screen("add_deck")
    object DeckDetail : Screen("deck_detail/{deckId}") {
        fun createRoute(deckId: Long) = "deck_detail/$deckId"
    }
    object CardStudy : Screen("card_study/{deckId}") {
        fun createRoute(deckId: Long) = "card_study/$deckId"
    }
    object AddCard : Screen("add_card/{deckId}") {
        fun createRoute(deckId: Long) = "add_card/$deckId"
    }
    object Progress : Screen("progress")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(Screen.DeckList.route) {
            DeckListScreen(
                navController = navController,
                onDeckClick = { deckId ->
                    navController.navigate(Screen.DeckDetail.createRoute(deckId))
                },
                onAddDeck = {
                    navController.navigate(Screen.AddDeck.route)
                }
            )
        }

        composable(Screen.AddDeck.route) {
            AddDeckScreen(navController = navController)
        }

        composable(
            route = Screen.DeckDetail.route,
            arguments = listOf(navArgument("deckId") { type = NavType.LongType })
        ) { backStackEntry ->
            val deckId = backStackEntry.arguments?.getLong("deckId") ?: 0L
            DeckDetailScreen(
                navController = navController,
                deckId = deckId
            )
        }

        composable(
            route = Screen.CardStudy.route,
            arguments = listOf(navArgument("deckId") { type = NavType.LongType })
        ) { backStackEntry ->
            val deckId = backStackEntry.arguments?.getLong("deckId") ?: 0L
            CardStudyScreen(
                navController = navController,
                deckId = deckId
            )
        }

        composable(
            route = Screen.AddCard.route,
            arguments = listOf(navArgument("deckId") { type = NavType.LongType })
        ) { backStackEntry ->
            val deckId = backStackEntry.arguments?.getLong("deckId") ?: 0L
            AddCardScreen(
                navController = navController,
                deckId = deckId
            )
        }

        composable(Screen.Progress.route) {
            ProgressScreen(navController = navController)
        }
    }
}