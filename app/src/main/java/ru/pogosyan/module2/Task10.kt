package ru.pogosyan.module2

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.random.Random

data class Cart(
    val products: List<Product>
)

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

// Задание 10. Исправленная корзина: сумма и количество вычисляются из состояния,
// а не накапливаются в полях активити при каждой рекомпозиции
@Composable
fun ShoppingCartScreen(modifier: Modifier = Modifier) {
    var cart by remember {
        mutableStateOf(
            Cart(
                listOf(
                    Product(0, "Товар #1", 100),
                    Product(1, "Товар #2", 150),
                    Product(2, "Товар #3", 56)
                )
            )
        )
    }
    val products = cart.products
    val totalSum = products.sumOf { it.price }

    Column(modifier = modifier.padding(16.dp)) {
        for (product in products) {
            Text(text = product.name + " - " + product.price + " рублей")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")
        AddProductSection(totalSum = totalSum) {
            cart = Cart(
                products + Product(
                    id = products.size,
                    name = "Товар #${products.size + 1}",
                    price = Random.nextInt(0, 100)
                )
            )
        }
        RemoveProductSection(productSize = products.size) {
            cart = Cart(products.dropLast(1))
        }
    }
}

@Composable
fun AddProductSection(
    totalSum: Int,
    onAdd: () -> Unit
) {
    val context = LocalContext.current
    val freeDelivery = totalSum > 500
    // Toast — побочный эффект: показываем его один раз при переходе порога 500,
    // а не при каждой рекомпозиции
    LaunchedEffect(freeDelivery) {
        if (freeDelivery) {
            Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
        }
    }
    Button(onClick = onAdd) {
        Text(text = "Добавить товар")
    }
}

@Composable
fun RemoveProductSection(
    productSize: Int,
    onRemove: () -> Unit
) {
    if (productSize > 0) {
        Button(onClick = onRemove) {
            Text(text = "Удалить товар")
        }
    }
}
