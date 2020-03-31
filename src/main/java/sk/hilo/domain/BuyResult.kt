package sk.hilo.domain

data class BuyResult(
        val buyPrice: Double,
        val sellPrice: Double,
        val cryptoVolumeAtBuy: Double,
        val cryptoVolumeAtSell: Double,
        val balance: Double
) {
}