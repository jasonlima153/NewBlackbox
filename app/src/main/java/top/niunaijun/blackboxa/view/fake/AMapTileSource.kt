package top.niunaijun.blackboxa.view.fake

import org.osmdroid.tileprovider.MapTileProviderBasic
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase
import org.osmdroid.tileprovider.tilesource.XYTileSource
import org.osmdroid.util.MapTileIndex

/**
 * 高德地图瓦片源 - 替代 OpenStreetMap，完美显示中国地图
 * 无需 API Key，直接加载高德公开瓦片 URL
 */
object AMapTileSource {

    // 高德标准矢量地图（电子地图）
    val VECTOR: OnlineTileSourceBase = object : XYTileSource(
        "AMap-Vector",
        0, 18, 256,
        ".png",
        arrayOf(
            "https://wprd01.is.autonavi.com/appmaptile?",
            "https://wprd02.is.autonavi.com/appmaptile?",
            "https://wprd03.is.autonavi.com/appmaptile?",
            "https://wprd04.is.autonavi.com/appmaptile?"
        )
    ) {
        override fun getTileURLString(pMapTileIndex: Long): String {
            return baseUrl + "x=" + MapTileIndex.getX(pMapTileIndex)
                    + "&y=" + MapTileIndex.getY(pMapTileIndex)
                    + "&z=" + MapTileIndex.getZoom(pMapTileIndex)
                    + "&lang=zh_cn&size=1&scl=1&style=7&ltype=7"
        }
    }

    // 高德卫星影像图
    val SATELLITE: OnlineTileSourceBase = object : XYTileSource(
        "AMap-Satellite",
        0, 18, 256,
        ".png",
        arrayOf(
            "https://wprd01.is.autonavi.com/appmaptile?",
            "https://wprd02.is.autonavi.com/appmaptile?",
            "https://wprd03.is.autonavi.com/appmaptile?",
            "https://wprd04.is.autonavi.com/appmaptile?"
        )
    ) {
        override fun getTileURLString(pMapTileIndex: Long): String {
            return baseUrl + "x=" + MapTileIndex.getX(pMapTileIndex)
                    + "&y=" + MapTileIndex.getY(pMapTileIndex)
                    + "&z=" + MapTileIndex.getZoom(pMapTileIndex)
                    + "&lang=zh_cn&size=1&scl=1&style=6&ltype=6"
        }
    }
}
