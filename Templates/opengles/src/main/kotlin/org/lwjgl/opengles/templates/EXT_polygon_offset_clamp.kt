/*
 * Copyright LWJGL. All rights reserved.
 * License terms: http://lwjgl.org/license.php
 */
package org.lwjgl.opengles.templates

import org.lwjgl.generator.*
import org.lwjgl.opengles.*

val EXT_polygon_offset_clamp = "EXTPolygonOffsetClamp".nativeClassGLES("EXT_polygon_offset_clamp", postfix = EXT) {
	documentation =
		"""
		Native bindings to the $registryLink extension.

		This extension adds a new parameter to the polygon offset function that clamps the calculated offset to a minimum or maximum value. The clamping
		functionality is useful when polygons are nearly parallel to the view direction because their high slopes can result in arbitrarily large polygon
		offsets. In the particular case of shadow mapping, the lack of clamping can produce the appearance of unwanted holes when the shadow casting polygons
		are offset beyond the shadow receiving polygons, and this problem can be alleviated by enforcing a maximum offset value.
		"""

	IntConstant(
		"Accepted by the {@code pname} parameters of GetBooleanv, GetIntegerv, GetInteger64v, GetFloatv, and GetDoublev.",

		"POLYGON_OFFSET_CLAMP_EXT"..0x8E1B
	)

	void(
		"PolygonOffsetClampEXT",
		"""
		The depth values of all fragments generated by the rasterization of a polygon may be offset by a single value that is computed for that polygon. The
		function that determines this value is specified with this command.

		{@code factor} scales the maximum depth slope of the polygon, and {@code units} scales an implementation-dependent constant that relates to the usable
		resolution of the depth buffer. The resulting values are summed to produce the polygon offset value, which may then be clamped to a minimum or maximum
		value specified by {@code clamp}. The values {@code factor}, {@code units}, and {@code clamp} may each be positive, negative, or zero. Calling the
		command GLES20#PolygonOffset() is equivalent to calling the command PolygonOffsetClampEXT with {@code clamp} equal to zero."
		""",

		GLfloat.IN("factor", "scales the maximum depth slope of the polygon"),
		GLfloat.IN("units", "scales an implementation-dependent constant that relates to the usable resolution of the depth buffer"),
		GLfloat.IN("clamp", "the minimum or maximum clamp value")
	)
}