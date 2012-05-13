/*
 * This file is part of Quelea, free projection software for churches.
 * 
 * Copyright (C) 2012 Michael Berry
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.quelea;

import java.awt.image.BufferedImage;

/**
 * The background interface for different types of background.
 *
 * @author Michael
 */
public interface Background {

    /**
     * Get a preview image of this background in the given dimensions.
     *
     * @param width the width of the image to get.
     * @param height the height of the image to get.
     * @param key the key, can be used for internal caching to speed things up,
     * or ignored.
     * @return an image with the given dimensions.
     */
    BufferedImage getImage(int width, int height, String key);

    /**
     * Generate a consistent DB string for storing in a database.
     *
     * @return the DB string.
     */
    String toDBString();
}
